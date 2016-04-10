package com.example.SearchView;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MyActivity extends Activity {
    private SearchView sv;
    private ListView lv;
    private final String[] mStrings={"aaa","bbbb","ccccc"};
    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lv=(ListView)findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mStrings));
        lv.setTextFilterEnabled(true);
        sv=(SearchView)findViewById(R.id.sv);
        sv.setIconifiedByDefault(false);
        sv.setSubmitButtonEnabled(true);
        sv.setQueryHint("查找");
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                if(TextUtils.isEmpty(newText))
                {
                    lv.clearTextFilter();
                }
                else
                {
                    lv.setFilterText(newText);
                }
                return true;
            }


            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MyActivity.this,"您的选择是:"+query,
                Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}
