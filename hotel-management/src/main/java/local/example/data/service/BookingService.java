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

package local.example.data.service;

import static local.example.data.scheme.dao.BookingDao.BOOKING_DAO;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import local.example.data.domain.Booking;
import local.example.data.scheme.dao.record.BookingRecord;

@Service
@Transactional
public class BookingService {

	@Autowired
	private DSLContext dslContext;
	
	public Booking createBooking(Booking booking) {
		BookingRecord bookingRecord = (BookingRecord) dslContext
				.insertInto(BOOKING_DAO)
				.set(BOOKING_DAO.VACANCY, booking.getVacancy())
				.set(BOOKING_DAO.CHECK_IN, booking.getCheckIn())
				.set(BOOKING_DAO.CHECK_OUT, booking.getCheckOut());
		booking.setId(bookingRecord.component1());
		return booking;
	}
}
