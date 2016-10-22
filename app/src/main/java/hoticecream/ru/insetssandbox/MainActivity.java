package hoticecream.ru.insetssandbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new SampleAdapter());
    }

    public static class SampleAdapter extends RecyclerView.Adapter<SampleHolder> {

        private List<Object> items = Arrays.asList(new Object(), new Object(), new Object(), new Object(), new Object(), new Object(), new Object(), new Object(), new Object(), new Object());

        @Override
        public SampleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SampleHolder(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_sample, parent, false));
        }

        @Override
        public void onBindViewHolder(SampleHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }

    public static class SampleHolder extends RecyclerView.ViewHolder {

        public SampleHolder(View itemView) {
            super(itemView);
        }
    }
}
