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
package org.openmidaas.app.session;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.openmidaas.app.common.Constants;
import org.openmidaas.library.model.EmailAttribute;
import org.openmidaas.library.model.core.AbstractAttribute;
import org.openmidaas.library.model.core.MIDaaSException;
import org.openmidaas.library.persistence.AttributePersistenceCoordinator;
import org.openmidaas.library.persistence.core.EmailDataCallback;

public class EmailAttributeSet extends AbstractAttributeSet {

	
	protected EmailAttributeSet() {
		mType = Constants.AttributeNames.EMAIL;
	}
	
	@Override
	public void fetch(){
		final CountDownLatch MUTEX = new CountDownLatch(1);
		AttributePersistenceCoordinator.getEmails(new EmailDataCallback() {

			@Override
			public void onError(MIDaaSException arg0) {
				MUTEX.countDown();
			}

			@Override
			public void onSuccess(List<EmailAttribute> emailList) {
				mAttributeList.addAll(emailList);
				MUTEX.countDown();
			}
			
		});
		try {
			MUTEX.await(TIMEOUT, TIME_UNIT);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onModify() {
		
	}
}
