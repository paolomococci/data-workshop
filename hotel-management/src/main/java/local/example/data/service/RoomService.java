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

import static local.example.data.scheme.dao.RoomDao.ROOM_DAO;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import local.example.data.domain.Room;
import local.example.data.scheme.dao.record.RoomRecord;

@Service
@Transactional
public class RoomService {

	@Autowired
	private DSLContext dslContext;
	
	public Room createRoom(Room room) {
		RoomRecord roomRecord = (RoomRecord) dslContext
				.insertInto(ROOM_DAO)
				.set(ROOM_DAO.BEDS, room.getBeds())
				.set(ROOM_DAO.BASE_PRICE, room.getBasePrice())
				.set(ROOM_DAO.BATHROOM, room.getBathroom())
				.set(ROOM_DAO.FRIGOBAR, room.getFrigobar())
				.set(ROOM_DAO.COOLING_FAN, room.getCoolingFan())
				.set(ROOM_DAO.AIR_CONDITIONING, room.getAirConditioning())
				.set(ROOM_DAO.LAUNDRY, room.getLaundry())
				.set(ROOM_DAO.SHOEMAKER, room.getShoemaker())
				.set(ROOM_DAO.CATERING, room.getCatering())
				.set(ROOM_DAO.WIFI, room.getWifi())
				.set(ROOM_DAO.GIGABIT_ETHERNET, room.getGigabitEthernet())
				.set(ROOM_DAO.PRIVATE_BALCONY, room.getPrivateBalcony());
		room.setId(roomRecord.component1());
		return room;
	}
}
