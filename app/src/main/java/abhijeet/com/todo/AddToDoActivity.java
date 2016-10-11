package abhijeet.com.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Jitish on 15-06-2016.
 */
public class AddToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
    }

    public void addTodo(View v) {
        EditText title = (EditText) findViewById(R.id.taskname);
        String str = title.getText().toString();
        if (!str.isEmpty()) {
            MainActivity.todoList.add(new TODO(str));
            MainActivity.adapter.notifyDataSetChanged();
            Log.d("Size", MainActivity.adapter.getItemCount() + "");
            finish();
        }
    }
}

