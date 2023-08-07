package com.example.mboga

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.mboga.databinding.ActivityMainBinding
import com.example.mboga.ui.theme.MbogaTheme

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    var dataArrayList = ArrayList<ListData?>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameList = arrayOf("Pasta", "Maggi", "Cake", "Pancake", "Pizza", "Burgers", "Fries")
        val timeList = arrayOf("30 mins", "2 mins", "45 mins", "10 mins", "60 mins", "45 mins", "30 mins")

        val imageList = intArrayOf(
            R.drawable.list1,
            R.drawable.list2,
            R.drawable.list3,
            R.drawable.list4,
            R.drawable.list5,
            R.drawable.list6,
            R.drawable.list6
        )
        val ingredientList = intArrayOf(
            R.string.pastaIngredients,
            R.string.maggiIngredients,
            R.string.cakeIngredients,
            R.string.pancakeIngredients,
            R.string.pizzaIngredients,
            R.string.burgerIngredients,
            R.string.friesIngredients
        )
        val descList = intArrayOf(
            R.string.pastaDesc,
            R.string.maggieDesc,
            R.string.cakeDesc,
            R.string.pancakeDesc,
            R.string.pizzaDesc,
            R.string.burgerDesc,
            R.string.friesDesc
        )
        for (i in imageList.indices) {
            listData = ListData(
                nameList[i],
                timeList[i], ingredientList[i], descList[i], imageList[i]
            )
            dataArrayList.add(listData)
        }
        listAdapter = ListAdapter(this@MainActivity, dataArrayList)
        binding.listView.adapter = listAdapter
        binding.listView.isClickable = true

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener{ adapterView, view, i, l ->
            val intent = Intent(this@MainActivity, DetailedActivity::class.java)
            intent.putExtra("name", nameList[i])
            intent.putExtra("time", timeList[i])
            intent.putExtra("ingredients", ingredientList[i])
            intent.putExtra("desc", descList[i])
            intent.putExtra("image", imageList[i])
            startActivity(intent)
        }

        Thread.sleep(3000)
        installSplashScreen()
        setContent {
            MbogaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }

            }
        }
        }


    }

@Preview(showBackground = true, widthDp = 390, heightDp = 800)
@Composable
fun GreetingPreview() {
    MbogaTheme {
        
    }
}