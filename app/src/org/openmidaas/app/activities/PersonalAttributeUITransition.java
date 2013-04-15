/*******************************************************************************
 * Copyright 2013 SecureKey Technologies Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.openmidaas.app.activities;

import java.util.ArrayList;

import org.openmidaas.app.common.CategoryMap;
import org.openmidaas.app.common.UINotificationUtils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class PersonalAttributeUITransition implements AddButtonClickDelegate {

	@Override
	public void onButtonClick(final Activity activity) {
		ArrayList<String> list = CategoryMap.getLabelsForCategory("Personal");
		final CharSequence[] items = list.toArray(new CharSequence[list.size()]);
		new AlertDialog.Builder(activity)
		.setTitle("Please select the value you wish to enter")
        .setSingleChoiceItems(items, 0, null)
        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
                int selectedPosition = ((AlertDialog)dialog).getListView().getCheckedItemPosition();
                UINotificationUtils.showAttributeValueCollectionDialog(activity, CategoryMap.getEnumsForCategory("Personal").get(selectedPosition).getAttributeName(), items[selectedPosition].toString());
            }
        })
        .show();
	}

}