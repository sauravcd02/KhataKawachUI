package com.mhvmedia.khatakawachui.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.mhvmedia.khatakawachui.databinding.ActivityFirstScreenBinding;
import com.mhvmedia.khatakawachui.databinding.PopupAddReminderBinding;

public class FirstScreen extends AppCompatActivity {
    private ActivityFirstScreenBinding binding;
    private PopupAddReminderBinding popupAddReminderBinding;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Sales.class);
                startActivity(intent);
            }
        });

        binding.newinvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), NewInvoice.class);
                startActivity(intent);
            }
        });

        binding.addclient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AddClient.class);
                startActivity(intent);
            }
        });

        binding.client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AllClientList.class);
                startActivity(intent);
            }
        });

        binding.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Profile.class);
                startActivity(intent);
            }
        });

        binding.addreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupReminder popupReminder = new PopupReminder();
                popupReminder.showDialog1(FirstScreen.this);
            }
        });

        binding.product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ProductList.class);
                startActivity(intent);
            }
        });

        binding.stuff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AddStuff.class);
                startActivity(intent);
            }
        });

        binding.settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Settings.class);
                startActivity(intent);
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////

        binding.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.drawerLayout.getVisibility() == View.GONE) {
                    binding.drawerLayout.setVisibility(View.VISIBLE);
                 /*  Animation animation   =    AnimationUtils.loadAnimation(getApplicationContext(), R.anim.layout_animation);
                    animation.setDuration(750);
                    binding.drawerLayout.setAnimation(animation);
                    binding.drawerLayout.animate();
                    animation.start();
                    animation.cancel();*/
                } else {
                    /*binding.drawerLayout.setVisibility(View.GONE);
                    Animation animation   =    AnimationUtils.loadAnimation(getApplicationContext(), R.anim.layout_animation_2);
                    animation.setDuration(750);
                    binding.drawerLayout.setAnimation(animation);
                    binding.drawerLayout.animate();
                    animation.start();
                    animation.cancel();*/

                    binding.drawerLayout.setVisibility(View.GONE);
                }
            }
        });

        binding.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.drawerLayout.setVisibility(View.GONE);
               /* Animation animation   =    AnimationUtils.loadAnimation(getApplicationContext(), R.anim.layout_animation_2);
                animation.setDuration(750);
                binding.drawerLayout.setAnimation(animation);
                binding.drawerLayout.animate();
                animation.start();
                binding.drawerLayout.setVisibility(View.GONE);
                animation.cancel();*/
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////

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

}