package net.skhu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    MainAdapter recyclerViewAdapter;
    ArrayList<String> arrayList;
    ArrayList<String> keyList = new ArrayList<>();
    DatabaseReference item06;

    ChildEventListener firebaseListener = new ChildEventListener() {
        private int findIndex(String key) {
            return Collections.binarySearch(keyList, key);
        }

        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
            String key = dataSnapshot.getKey();
            String item = dataSnapshot.getValue(String.class);
            arrayList.add(item);
            keyList.add(key);
            recyclerViewAdapter.notifyItemInserted(arrayList.size() - 1);
        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
            String key = dataSnapshot.getKey();
            String item = dataSnapshot.getValue(String.class);
            int index = findIndex(key);
            arrayList.set(index, item);
            recyclerViewAdapter.notifyItemChanged(index);
        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {
        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<String>();

        recyclerViewAdapter = new MainAdapter(this, arrayList);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_create) {
            Intent intent = new Intent(this, Memo3Activity.class);
            activityResultLauncher.launch(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void onMemoClicked(int index){
        Intent intent = new Intent(this, MemoActivity.class);
        String memo = arrayList.get(index);
        intent.putExtra("MEMO", memo);
        intent.putExtra("index", index);
        //onActivityResultLauncher.launch(intent);
    }
}



