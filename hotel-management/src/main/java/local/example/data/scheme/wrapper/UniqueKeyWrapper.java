/**
 *
 * Copyright 2019 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.data.scheme.wrapper;

import org.jooq.UniqueKey;
import org.jooq.impl.Internal;

import local.example.data.scheme.dao.BookingDao;
import local.example.data.scheme.dao.CustomerDao;
import local.example.data.scheme.dao.RoomDao;
import local.example.data.scheme.dao.record.BookingRecord;
import local.example.data.scheme.dao.record.CustomerRecord;
import local.example.data.scheme.dao.record.RoomRecord;

public class UniqueKeyWrapper {

	public static final UniqueKey<CustomerRecord> KEY_CUSTOMER_PRIMARY = Internal
			.createUniqueKey(
					CustomerDao.CUSTOMER_DAO, 
					"KEY_customer_PRIMARY", 
					CustomerDao.CUSTOMER_DAO.ID);
	public static final UniqueKey<RoomRecord> KEY_ROOM_PRIMARY = Internal
			.createUniqueKey(
					RoomDao.ROOM_DAO, 
					"KEY_room_PRIMARY", 
					RoomDao.ROOM_DAO.ID);
	public static final UniqueKey<BookingRecord> KEY_BOOKING_PRIMARY = Internal
			.createUniqueKey(
					BookingDao.BOOKING_DAO, 
					"KEY_booking_PRIMARY", 
					BookingDao.BOOKING_DAO.ID);
}
