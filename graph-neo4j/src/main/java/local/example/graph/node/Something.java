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

package local.example.graph.node;

import local.example.graph.relationship.Think;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Something {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter
    @Relationship(
            type = "THINK TO",
            direction = Relationship.INCOMING
    )
    private List<Think> thinks;

    @Getter
    @Setter
    private String code;

    public void addThink(Think think) {
        if (this.thinks == null) this.thinks = new ArrayList<>();
        this.thinks.add(think);
    }
}
