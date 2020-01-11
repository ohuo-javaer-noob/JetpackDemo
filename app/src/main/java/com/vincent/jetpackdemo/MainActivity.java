package com.vincent.jetpackdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.vincent.jetpackdemo.adapter.MyRecyAdapter;
import com.vincent.jetpackdemo.databinding.ActivityMainBinding;
import com.vincent.jetpackdemo.entity.EntityWord;
import com.vincent.jetpackdemo.viewmodel.WordViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //todo:是否使用dagger2 需要考虑

    private ActivityMainBinding binding;
    private WordViewModel wordViewModel;
    private MyRecyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        bindView();

        bindData();


    }

    private void bindView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        adapter = new MyRecyAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setAdapter(adapter);
        binding.insertBtn.setOnClickListener(this);
        binding.clearBtn.setOnClickListener(this);

    }

    private void bindData() {
        //bing data
        wordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        wordViewModel.getListLiveData().observe(this, new Observer<List<EntityWord>>() {
            @Override
            public void onChanged(List<EntityWord> entityWords) {
                StringBuilder wordStr = new StringBuilder();
                for (EntityWord word : entityWords) {
                    wordStr.append(word.toString());
                }
                adapter.setWordList(entityWords);
                adapter.notifyDataSetChanged();
                binding.recyclerView.scrollToPosition(entityWords.size() - 1);
//                Toast.makeText(MainActivity.this, wordStr.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert_btn:
                EntityWord word1 = new EntityWord("banjitino", "班级tino");
                EntityWord word2 = new EntityWord("word2", "词语2");
                wordViewModel.insertWords(word1, word2);
                break;
            case R.id.clear_btn:
                wordViewModel.deleteAllWords();
                break;
            default:
                break;
        }

    }


}
