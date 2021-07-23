package com.mhvmedia.khatakawachui.Fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mhvmedia.khatakawachui.Activity.FirstScreen;
import com.mhvmedia.khatakawachui.databinding.FragmentClientAccountBinding;
import com.mhvmedia.khatakawachui.databinding.PopupAddReminderBinding;
import com.mhvmedia.khatakawachui.databinding.PopupBankAddBinding;

public class ClientAccount extends Fragment {
    FragmentClientAccountBinding binding;
    private PopupBankAddBinding popupBankAddBinding;
    private Dialog dialog;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentClientAccountBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        // code here

        binding.addeditbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupAddBank popupReminder = new PopupAddBank();
                popupReminder.showDialog1();
            }
        });

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

    }

    class PopupAddBank {
        public void showDialog1() {
            dialog = new Dialog(getContext());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            popupBankAddBinding = PopupBankAddBinding.inflate(getLayoutInflater());
            View phoneVerificationView = popupBankAddBinding.getRoot();
            dialog.setContentView(phoneVerificationView);
            dialog.setCancelable(true);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            popupBankAddBinding.additem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    binding.bankName.setText(popupBankAddBinding.bankName.getText().toString());
                    binding.bankinfostatus.setText("Edit Bank");
                    dialog.cancel();
                }
            });

            popupBankAddBinding.close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.cancel();
                }
            });

            dialog.show();
        }
    }

}
