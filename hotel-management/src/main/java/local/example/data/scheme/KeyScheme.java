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

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.types.ULong;

import local.example.data.scheme.dao.record.BookingRecord;
import local.example.data.scheme.dao.record.CustomerRecord;
import local.example.data.scheme.dao.record.RoomRecord;
import local.example.data.scheme.wrapper.ForeignKeyWrapper;
import local.example.data.scheme.wrapper.IdentityWrapper;
import local.example.data.scheme.wrapper.UniqueKeyWrapper;

public class KeyScheme {

	public static final Identity<CustomerRecord, ULong> IDENTITY_CUSTOMER = IdentityWrapper.IDENTITY_CUSTOMER;
	public static final Identity<RoomRecord, ULong> IDENTITY_ROOM = IdentityWrapper.IDENTITY_ROOM;
	public static final Identity<BookingRecord, ULong> IDENTITY_BOOKING = IdentityWrapper.IDENTITY_BOOKING;
	
	public static final UniqueKey<CustomerRecord> KEY_CUSTOMER_PRIMARY = UniqueKeyWrapper.KEY_CUSTOMER_PRIMARY;
	public static final UniqueKey<RoomRecord> KEY_ROOM_PRIMARY = UniqueKeyWrapper.KEY_ROOM_PRIMARY;
	public static final UniqueKey<BookingRecord> KEY_BOOKING_PRIMARY = UniqueKeyWrapper.KEY_BOOKING_PRIMARY;
	
	public static final ForeignKey<BookingRecord, CustomerRecord> BOOKING_CUSTOMER_FK = ForeignKeyWrapper.BOOKING_CUSTOMER_FK;
	public static final ForeignKey<BookingRecord, RoomRecord> BOOKING_ROOM_FK = ForeignKeyWrapper.BOOKING_ROOM_FK;
}
