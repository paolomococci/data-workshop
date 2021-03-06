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

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;

import local.example.data.scheme.dao.BookingDao;
import local.example.data.scheme.dao.CustomerDao;
import local.example.data.scheme.dao.RoomDao;

public class IndexWrapper {

	public static Index CUSTOMER_PRIMARY = Internal.createIndex(
			"PRIMARY", 
			CustomerDao.CUSTOMER_DAO, 
			new OrderField[] {CustomerDao.CUSTOMER_DAO.ID}, 
			true);
	public static Index ROOM_PRIMARY = Internal.createIndex(
			"PRIMARY", 
			RoomDao.ROOM_DAO, 
			new OrderField[] {RoomDao.ROOM_DAO.ID}, 
			true);
	public static Index BOOKING_PRIMARY = Internal.createIndex(
			"PRIMARY", 
			BookingDao.BOOKING_DAO, 
			new OrderField[] {BookingDao.BOOKING_DAO.ID}, 
			true);
}
