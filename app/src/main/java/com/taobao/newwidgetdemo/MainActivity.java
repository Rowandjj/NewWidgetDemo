package com.taobao.newwidgetdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private ViewGroup mContent;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);


        //drawer & toolbar

        Toolbar toolbar = (Toolbar) findViewById(R.id.title_bar);
        setSupportActionBar(toolbar);

        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.hello_world, R.string.hello_blank_fragment);
        drawerLayout.setDrawerListener(toggle);
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        //NavigationView

        NavigationView navView = (NavigationView) findViewById(R.id.nav);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.navigation_item_1:
                        Toast.makeText(MainActivity.this,"item1",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_item_2:
                        Toast.makeText(MainActivity.this,"item2",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_item_3:
                        Toast.makeText(MainActivity.this,"item3",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_item_4:
                        Toast.makeText(MainActivity.this,"item4",Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });




        mContent = (ViewGroup) findViewById(R.id.main_content);
        //snackbar
        findViewById(R.id.btn_snackbar).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //SNACK BAR
                showSnackBar();
            }
        });





        //FAB
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "ADD", Toast.LENGTH_SHORT).show();
            }
        });

        //TextInputLayout
        EditText et = (EditText) findViewById(R.id.et);
        final TextInputLayout inputLayout = (TextInputLayout) findViewById(R.id.input_layout);
        et.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (s.length() > 4)
                {
                    inputLayout.setErrorEnabled(true);
                    inputLayout.setError("用户名过长");
                } else
                {
                    inputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });

        findViewById(R.id.tablayout).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, TabActivity.class));
            }
        });

        findViewById(R.id.btn_app_bar).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, AppbarActivity.class));
            }
        });
        findViewById(R.id.btn_tool_bar).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, CollpasingToolbarActivity.class));
            }
        });

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }


    private void showSnackBar()
    {
        Snackbar.make(findViewById(R.id.coo_content), "我是SNACK BAR", Snackbar.LENGTH_SHORT).setActionTextColor(0xff00ff00).setAction("ABOUT", new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showDialog();
            }
        }).show();
    }

    private void showDialog()
    {
        new AlertDialog.Builder(this).setTitle("ABOUT").setMessage("android爱好者").setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        }).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
