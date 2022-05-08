package com.belajar.colalin.accountView.viewModelAcc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.belajar.colalin.R;
import com.belajar.colalin.accountView.NewPasswordFragment;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class ViewModelAuth extends ViewModel {
    private final FirebaseAuth mAuth;
    private String phone;
    private String username;
    @SuppressLint("StaticFieldLeak")
    private FragmentActivity context;
    private String code;
    private String vertifID;
    private final Fragment fragment;

    public FragmentActivity getContext() {
        return context;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setContext(FragmentActivity context) {
        this.context = context;
    }

    public ViewModelAuth() {
        mAuth = FirebaseAuth.getInstance();
        mAuth.getFirebaseAuthSettings().setAppVerificationDisabledForTesting(true);
        fragment = new NewPasswordFragment();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void sendOTP(){
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(mAuth)
                .setPhoneNumber("+62"+getPhone())
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(context)
                .setCallbacks(mCallBack)
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential
                                                            phoneAuthCredential) {
                    code = phoneAuthCredential.getSmsCode();
                    assert code != null;
                    if (code.equals("")){
                        vertifOTP(code);
                    }
                }

                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {
                    Toast.makeText(context, "Vertifikasi Gagal", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider
                        .ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    vertifID = s;
                }
            };
    public void vertifOTP(String code){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(vertifID, code);
        signingbyCrendtials(credential);
    }

    private void signingbyCrendtials(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(context, "Vertivikasi Berhasil",Toast.LENGTH_SHORT)
                                .show();
                        Bundle bundle = new Bundle();
                        bundle.putString("phone",getPhone());
                        bundle.putString("username",getUsername());
                        fragment.setArguments(bundle);
                        context.getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container_account_view, fragment).addToBackStack(null)
                                .commit();
                    }else{
                        Toast.makeText(context, "Vertivikasi Gagal",Toast.LENGTH_SHORT)
                                .show();
                    }
                });
    }
}
