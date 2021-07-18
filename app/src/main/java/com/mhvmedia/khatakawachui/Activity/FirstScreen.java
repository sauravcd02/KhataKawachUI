package com.mhvmedia.khatakawachui.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;
import com.mhvmedia.khatakawachui.R;
import com.mhvmedia.khatakawachui.databinding.ActivityAllClientListBinding;
import com.mhvmedia.khatakawachui.databinding.ActivityFirstScreenBinding;
import com.mhvmedia.khatakawachui.databinding.ActivityFirstScreenContentsBinding;
import com.mhvmedia.khatakawachui.databinding.PopupAddReminderBinding;

public class FirstScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActivityFirstScreenBinding binding;
    private ActivityFirstScreenContentsBinding contentsBinding;

    private PopupAddReminderBinding popupAddReminderBinding;
    private Dialog dialog;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        contentsBinding = binding.contents;

        setNavigationViewListener();

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.first_screen, R.id.sales, R.id.account, R.id.client, R.id.analytics, R.id.product, R.id.profile, R.id.stuff, R.id.settings)
                .setDrawerLayout(drawer)
                .build();

       /* NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_first_scrren_with_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);*/


        contentsBinding.newinvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), NewInvoice.class);
                startActivity(intent);
            }
        });

        contentsBinding.addclient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AddClient.class);
                startActivity(intent);
            }
        });


        contentsBinding.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Profile.class);
                startActivity(intent);
            }
        });

        contentsBinding.addreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupReminder popupReminder = new PopupReminder();
                popupReminder.showDialog1(FirstScreen.this);
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////

        contentsBinding.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.drawerLayout.isDrawerOpen(Gravity.START)) {
                    binding.drawerLayout.closeDrawer(Gravity.START);
                } else {
                    binding.drawerLayout.openDrawer(Gravity.START);
                }
            }
        });

        getGraphDateData();
        ////////////////////////////////////////////////////////////////////////////////////////////

    }
    private void getGraphDateData() {
        // Initializing and set marital status
        final String[][] gender_array = {new String[]{"Last 7 Days", "Last 15 Days", "Last 1 Month", "Last 6 Month", "Last 12 Month"}};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_design, gender_array[0]);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_design);
        contentsBinding.graphTime.setAdapter(spinnerArrayAdapter);
        contentsBinding.graphTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String graphTime = String.valueOf(parent.getItemAtPosition(position));
                //Toast.makeText(getBaseContext(), religion, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    class PopupReminder {
        public void showDialog1(final FirstScreen activity) {
            dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            popupAddReminderBinding = PopupAddReminderBinding.inflate(getLayoutInflater());
            View phoneVerificationView = popupAddReminderBinding.getRoot();
            dialog.setContentView(phoneVerificationView);
            dialog.setCancelable(true);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            popupAddReminderBinding.close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.cancel();
                }
            });

            dialog.show();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {

            case R.id.sales: {
                //do somthing
                Intent intent = new Intent(getBaseContext(), Sales.class);
                startActivity(intent);
                break;
            }
            case R.id.account:
            case R.id.analytics: {
                //do somthing
                Intent intent = new Intent(getBaseContext(), EmptyActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.client: {
                //do somthing
                Intent intent = new Intent(getBaseContext(), AllClientList.class);
                startActivity(intent);
                break;
            }
            case R.id.product: {
                //do somthing
                Intent intent = new Intent(getBaseContext(), ProductList.class);
                startActivity(intent);
                break;
            }
            case R.id.profile: {
                //do somthing
                Intent intent = new Intent(getBaseContext(), Profile.class);
                startActivity(intent);
                break;
            }
            case R.id.stuff: {
                //do somthing
                Intent intent = new Intent(getBaseContext(), AddStuff.class);
                startActivity(intent);
                break;
            }
            case R.id.settings: {
                //do somthing
                Intent intent = new Intent(getBaseContext(), Settings.class);
                startActivity(intent);
                break;
            }
        }
        //close navigation drawer
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
}