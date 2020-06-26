/**
 *
 * Copyright 2020 paolo mococci
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

package local.example.warehouse.model.availability;

public enum ProductAvailability {

	COMING("Coming"), AVAILABLE("Available"), DISCONTINUED("Discontinued");

	private final String name;

	private ProductAvailability(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
