package sg.edu.rp.c346.id22017979.demodynamic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement, etIndexElement;
    Button btnAdd,btnRemove,btnUpdate;
    ListView lvColor;
    ArrayList<String> alColors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alColors = new ArrayList<String>();
        etElement = findViewById(R.id.editTextColor);
        btnAdd = findViewById(R.id.btnAddColor);
        btnRemove = findViewById(R.id.btnRemoveColor);
        btnUpdate = findViewById(R.id.btnUpdateColor);
        lvColor = findViewById(R.id.listViewColor);
        etIndexElement = findViewById(R.id.editTextIndex);

        alColors.add("Red");
        alColors.add("Orange");
        ArrayAdapter aaColor = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColors);
        lvColor.setAdapter(aaColor);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColor = etElement.getText().toString();
                //alColors.add(newColor);
                int pos = Integer.parseInt(etIndexElement.getText().toString()) - 1;

                alColors.add(pos,newColor);
                aaColor.notifyDataSetChanged();
                etElement.setText("");
                etIndexElement.setText("");
            }
        });
        lvColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String color = alColors.get(position);

                Toast.makeText(MainActivity.this, "Color selected: "+color, Toast.LENGTH_SHORT).show();
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String color = etElement.getText().toString();
                alColors.remove(color);
                aaColor.notifyDataSetChanged();
                etElement.setText("");
                etIndexElement.setText("");
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String color = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString()) - 1;
                alColors.set(pos,color);
                aaColor.notifyDataSetChanged();
                etElement.setText("");
                etIndexElement.setText("");
            }
        });

    }
}