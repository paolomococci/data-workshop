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

package local.example.data.domain;

import java.io.Serializable;

import org.jooq.types.ULong;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Room 
		implements Serializable {
	
	private static final long serialVersionUID = -388793165355572996L;
	private ULong id;
	private Integer beds;
	private Double basePrice;
	private Double bathroom;
	private Double frigobar;
	private Double coolingFan;
	private Double airConditioning;
	private Double laundry;
	private Double shoemaker;
	private Double catering;
	private Double wifi;
	private Double gigabitEthernet;
	private Double privateBalcony;
}
