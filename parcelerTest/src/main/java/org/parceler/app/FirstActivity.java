/**
 * Copyright 2011-2015 John Ericksen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.parceler.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.package1.name.UserVO;
import org.parceler.Parcels;
import org.parceler.lib.SecondActivity;

public class FirstActivity extends Activity implements OnClickListener {
    private TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        messageView = (TextView) findViewById(org.parceler.app.R.id.message);
        Button submitView = (Button) findViewById(R.id.submit);
        submitView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String message = messageView.getText().toString();
        UserVO userVO = new UserVO();
        userVO.setLastName(message);

        Intent intent = buildIntent(this, userVO);
        startActivity(intent);
    }

    public static Intent buildIntent(Context context, UserVO userVO) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(SecondActivity.EXTRA_EXAMPLE_PARCEL, Parcels.wrap(userVO));
        return intent;
    }
}