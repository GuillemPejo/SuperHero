package me.guillem.superhero

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.disposables.CompositeDisposable
import me.guillem.superhero.Adapter.Adapter
import me.guillem.superhero.retrofit.APIInterface
import me.guillem.superhero.retrofit.model.ApiClient
import me.guillem.superhero.retrofit.model.Hero

class MainActivity : AppCompatActivity() {

    private var adapter: Adapter? = null
    var rv_list: RecyclerView? = null
    private var apiInterface: APIInterface? = null
    private var herolist: List<Hero>? = null

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        getHeroList()

    }

    private fun getHeroList() {
        TODO("Not yet implemented")
    }

    private fun initRecyclerView() {

        apiInterface = ApiClient.getClient()?.create(APIInterface::class.java)

        rv_list = findViewById(R.id.rv_list)

        cryptoList = ArrayList()
        // Create adapter passing in the sample user data
        // Create adapter passing in the sample user data
        adapter = rvAdapter(cryptoList)
        // Attach the adapter to the recyclerview to populate items
        // Attach the adapter to the recyclerview to populate items
        rv_list.setAdapter(adapter)
    }
}