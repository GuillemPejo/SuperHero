package me.guillem.superhero.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import me.guillem.superhero.R
import me.guillem.superhero.retrofit.ServiceBuilder
import me.guillem.superhero.retrofit.model.Hero
import me.guillem.superhero.util.api_key
import kotlinx.android.synthetic.main.activity_main.*
import me.guillem.superhero.ui.adapter.Adapter


class MainActivity : AppCompatActivity() {
    val compositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        compositeDisposable.add(
            ServiceBuilder.buildService().getHero(api_key,12)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({response -> onResponse(response)}, {t -> onFailure(t) }))

    }


    private fun onFailure(t: Throwable) {
        Toast.makeText(this,t.message, Toast.LENGTH_SHORT).show()
    }

    private fun onResponse(response: Hero) {
        progress_bar.visibility = View.GONE
        rv_list.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter =
                Adapter(response.results)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}