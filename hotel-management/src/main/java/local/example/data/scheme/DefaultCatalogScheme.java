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

import java.util.Arrays;
import java.util.List;

import org.jooq.Schema;
import org.jooq.impl.CatalogImpl;

public class DefaultCatalogScheme 
	extends CatalogImpl {
	
	private static final long serialVersionUID = -8716412792020461409L;
	public static final DefaultCatalogScheme DEFAULT_CATALOG_SCHEME = new DefaultCatalogScheme();
	public final HotelScheme HOTEL = HotelScheme.HOTEL_SCHEME;
	

	public DefaultCatalogScheme() {
		super("");
	}

	@Override
	public List<Schema> getSchemas() {
		return Arrays.<Schema>asList(HotelScheme.HOTEL_SCHEME);
	}
}
