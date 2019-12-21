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

import org.jooq.ForeignKey;
import org.jooq.impl.Internal;

import local.example.data.scheme.dao.BookingDao;
import local.example.data.scheme.dao.record.BookingRecord;
import local.example.data.scheme.dao.record.CustomerRecord;
import local.example.data.scheme.dao.record.RoomRecord;

public class ForeignKeyWrapper {

	public static final ForeignKey<BookingRecord, CustomerRecord> BOOKING_CUSTOMER_FK = Internal
			.createForeignKey(
					UniqueKeyWrapper.KEY_CUSTOMER_PRIMARY, 
					BookingDao.BOOKING_DAO, 
					"booking_customer_FK", 
					BookingDao.BOOKING_DAO.ID);
	public static final ForeignKey<BookingRecord, RoomRecord> BOOKING_ROOM_FK = Internal
			.createForeignKey(
					UniqueKeyWrapper.KEY_ROOM_PRIMARY, 
					BookingDao.BOOKING_DAO, 
					"booking_room_FK", 
					BookingDao.BOOKING_DAO.ID);
}
