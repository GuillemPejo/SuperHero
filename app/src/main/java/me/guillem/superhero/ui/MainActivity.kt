package me.guillem.superhero.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import me.guillem.superhero.R
import me.guillem.superhero.retrofit.ServiceBuilder
import me.guillem.superhero.adapter.HeroAdapter
import me.guillem.superhero.retrofit.model.ProfileModel
import me.guillem.superhero.util.HttpCallFailureException
import me.guillem.superhero.util.NoNetworkException
import me.guillem.superhero.util.ServerUnreachableException


class MainActivity : AppCompatActivity() {
    private val compositeDisposable= CompositeDisposable()
    private val myAdapter by lazy { HeroAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init_rv()
        getHero()

        next.setOnClickListener{ view ->
            getHero()
        }
    }

    private fun getHero() {
        val rndm_num = (1..731).random()
        if(ServiceBuilder.isNetworkAvailable(this)){
                compositeDisposable.add(
                    ServiceBuilder.buildService().getHero(rndm_num.toString())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(this::handleResponse, this::handleError)
                )
            }

    }

    private fun init_rv() {
        rv_list.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            //rv_list.adapter = mAdapter
        }    }


    private fun handleError(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
        Log.e("this", t.message.toString())
        Log.e("this", t.localizedMessage)
        Log.e("this", t.cause.toString())
        Log.e("this", t.javaClass.toString())

        when (t) {
            is NoNetworkException -> displayNoNetworkError()
            is ServerUnreachableException -> displayServerUnreachableError()
            is HttpCallFailureException -> displayCallFailedError()
            else -> displayGenericError(t)
        }
    }

    private fun handleResponse(response: ProfileModel) {

            if (response.name.isNotEmpty()) {
                if (response.biography.full_name.isEmpty()) response.biography.full_name = response.name
                Log.d("TESTING","NOM: ${response.name} WITH ID: ${response.id}")
                myAdapter.setData(response, this)
                rv_list.adapter = myAdapter
            }else{
                getHero()
            }

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }


    private fun displayNoNetworkError() {
        Toast.makeText(this, "No network!", Toast.LENGTH_SHORT).show()
    }

    private fun displayServerUnreachableError() {
        Toast.makeText(this, "Server is unreachable!", Toast.LENGTH_SHORT).show()
    }

    private fun displayCallFailedError() {
        Toast.makeText(this, "Call failed!", Toast.LENGTH_SHORT).show()
    }

    private fun displayGenericError(error: Throwable) {
        Log.i("DEBUG", "Error in say hello", error)
        Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
    }


}



