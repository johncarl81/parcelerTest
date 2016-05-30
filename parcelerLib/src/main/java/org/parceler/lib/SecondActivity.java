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
package org.parceler.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.package1.name.UserVO;
import org.parceler.Parcels;

public class SecondActivity extends Activity {
    public static final String EXTRA_EXAMPLE_PARCEL = "example parcel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserVO userVO = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_EXAMPLE_PARCEL));

        setContentView(R.layout.activity_second);
        TextView messageView = (TextView) findViewById(R.id.message);
        messageView.setText(userVO.getLastName());
    }
}