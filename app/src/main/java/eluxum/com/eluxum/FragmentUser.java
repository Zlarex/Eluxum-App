package eluxum.com.eluxum;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentUser extends Fragment {

    TextView emt_user, emt_email, emt_biography, emt_address, emt_phone, emt_createdAt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View views = inflater.inflate(R.layout.activity_ele_user, null);
        emt_user = (TextView)views.findViewById(R.id.em_titlename);
        emt_email = (TextView)views.findViewById(R.id.em_email);
        emt_biography = (TextView)views.findViewById(R.id.em_biography);
        emt_address = (TextView)views.findViewById(R.id.em_address);
        emt_phone = (TextView)views.findViewById(R.id.em_phone);
        emt_createdAt = (TextView)views.findViewById(R.id.em_createdAt);

        emt_user.setText(DataAccount.name);
        emt_email.setText(DataAccount.email);
        emt_biography.setText(DataAccount.u_bio);
        emt_address.setText(DataAccount.u_address);
        emt_phone.setText(DataAccount.u_phone_number);
        emt_createdAt.setText(DataAccount.created_at);

        return views;
    }
}
