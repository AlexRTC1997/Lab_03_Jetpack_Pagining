//package org.idnp.jetpackpagingsample
//
//import android.os.Bundle
//import androidx.activity.viewModels
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.lifecycleScope
//import androidx.recyclerview.widget.DividerItemDecoration
//import androidx.recyclerview.widget.RecyclerView
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.launch
//import org.idnp.jetpackpagingsample.adapters.UserAdapter
//import org.idnp.jetpackpagingsample.junk.paging.UserViewModel
//
//class UserMainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.user_activity_main)
//
//        val viewModel by viewModels<UserViewModel>()
//        val recyclerView = findViewById<RecyclerView>(R.id.user_recycler_view)
//        val pagingAdapter = UserAdapter()
//
//        recyclerView.adapter = pagingAdapter
//        recyclerView.apply {
//            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
//        }
//
//        lifecycleScope.launch {
//            viewModel.items().collectLatest { pageData ->
//                pagingAdapter.submitData(pageData)
//            }
//        }
//    }
//
//}