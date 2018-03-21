package com.tech.suraj.mysqlitedemo;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    MyDatabase myDB;
    EditText name,quantity,cost;
    Button btn;
    Button btnViewAll;
    Button btnUpdate;
    Button  btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new MyDatabase(this);

        name =(EditText) findViewById(R.id.name);
        quantity = (EditText)findViewById(R.id.quantity);
        cost = (EditText)findViewById(R.id.cost);

        btn= (Button)findViewById(R.id.add);
        btnViewAll=(Button)findViewById(R.id.view);
        btnUpdate=(Button)findViewById(R.id.update);
        btnDelete=(Button)findViewById(R.id.remove);

        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDB.deleteData(name.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void UpdateData() {
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDB.updateData(name.getText().toString(),
                                quantity.getText().toString(),cost.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(MainActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void AddData()
    {

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                boolean isInserted = myDB.insertData(name.getText().toString(),quantity.getText().toString(),cost.getText().toString());

                if (isInserted == true)
                    Toast.makeText(MainActivity.this,"Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data Not Inserted", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void viewAll() {
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDB.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext())
                        {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Quantity :"+ res.getString(2)+"\n");
                            buffer.append("Cost :"+ res.getString(3)+"\n\n");
                        }
                        // Show all data
                        showMessage("Shopping Cart",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}

