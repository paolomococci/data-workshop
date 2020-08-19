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

package local.example.data.assembler;

import local.example.data.controller.ItemRestController;
import local.example.data.model.Item;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ItemRepresentationModelAssembler
        implements RepresentationModelAssembler<Item, EntityModel<Item>> {

    @Override
    public EntityModel<Item> toModel(Item item) {
        EntityModel<Item> itemEntityModel;
        try {
            itemEntityModel = EntityModel.of(item,
                    linkTo(methodOn(ItemRestController.class).read(item.getId())).withSelfRel(),
                    linkTo(methodOn(ItemRestController.class).readAll()).withRel("items"));
            return itemEntityModel;
        } catch (URISyntaxException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        }
        return EntityModel.of(new Item());
    }

    @Override
    public CollectionModel<EntityModel<Item>> toCollectionModel(
            Iterable<? extends Item> items) {
        return RepresentationModelAssembler.super.toCollectionModel(items);
    }
}
