extends Object
class_name TileData

var flip_h: bool;
var flip_v: bool;
var modulate: Color;
var probability: float;
var terrain_set: int;
var texture_offset: Vector2i;
var transpose: bool;
var y_sort_origin: int;
var z_index: int;

func add_collision_polygon(layer_id: int) -> void:
    pass;
func get_collision_polygon_one_way_margin(layer_id: int, polygon_index: int) -> float:
    pass;
func get_collision_polygon_points(layer_id: int, polygon_index: int) -> PackedVector2Array:
    pass;
func get_collision_polygons_count(layer_id: int) -> int:
    pass;
func get_custom_data(layer_name: String) -> Variant:
    pass;
func get_custom_data_by_layer_id(layer_id: int) -> Variant:
    pass;
func get_navigation_polygon(layer_id: int) -> NavigationPolygon:
    pass;
func get_occluder(layer_id: int) -> OccluderPolygon2D:
    pass;
func get_peering_bit_terrain(peering_bit: int) -> int:
    pass;
func is_collision_polygon_one_way(layer_id: int, polygon_index: int) -> bool:
    pass;
func remove_collision_polygon(layer_id: int, polygon_index: int) -> void:
    pass;
func set_collision_polygon_one_way(layer_id: int, polygon_index: int, one_way: bool) -> void:
    pass;
func set_collision_polygon_one_way_margin(layer_id: int, polygon_index: int, one_way_margin: float) -> void:
    pass;
func set_collision_polygon_points(layer_id: int, polygon_index: int, polygon: PackedVector2Array) -> void:
    pass;
func set_collision_polygons_count(layer_id: int, polygons_count: int) -> void:
    pass;
func set_custom_data(layer_name: String, value: Variant) -> void:
    pass;
func set_custom_data_by_layer_id(layer_id: int, value: Variant) -> void:
    pass;
func set_navigation_polygon(layer_id: int, navigation_polygon: NavigationPolygon) -> void:
    pass;
func set_occluder(layer_id: int, occluder_polygon: OccluderPolygon2D) -> void:
    pass;
func set_peering_bit_terrain(peering_bit: int, terrain: int) -> void:
    pass;
func tile_get_material() -> ShaderMaterial:
    pass;
func tile_set_material(material: ShaderMaterial) -> void:
    pass;
