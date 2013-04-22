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
import org.openmidaas.library.model.core.AbstractAttribute;

public abstract class AbstractListHeader {
	
	protected String mGroupName;
	
	protected ArrayList<AbstractAttributeListElement> mList = new ArrayList<AbstractAttributeListElement>();
	
	protected String mGroupLabel;

	protected AddButtonClickDelegate mTransition;
	
	public void setGroupName(String name) {
		this.mGroupName = name;
	}
	
	public void setGroupLabel(String label) {
		this.mGroupLabel = label;
	}
	
	public String getGroupLabel() {
		return mGroupLabel;
	}
	
	public String getGroupName() {
		return mGroupName;
	}
	
	public void setList(ArrayList<AbstractAttributeListElement> list) {
		this.mList = list;
	}
	
	public ArrayList<AbstractAttributeListElement> getList() {
		return mList;
	}
	
	protected abstract void setOnAddButtonClick();
	
	public AddButtonClickDelegate getAddButtonHandler() {
		return mTransition;
	}
}