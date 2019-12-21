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

package local.example.data.scheme;

import local.example.data.scheme.dao.BookingDao;
import local.example.data.scheme.dao.CustomerDao;
import local.example.data.scheme.dao.RoomDao;

public class TableScheme {

	public static final CustomerDao CUSTOMER_DAO = CustomerDao.CUSTOMER_DAO;
	public static final RoomDao ROOM_DAO = RoomDao.ROOM_DAO;
	public static final BookingDao BOOKING_DAO = BookingDao.BOOKING_DAO;
}
