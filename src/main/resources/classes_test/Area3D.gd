extends CollisionObject3D
class_name Area3D

const SPACE_OVERRIDE_DISABLED = 0;
const SPACE_OVERRIDE_COMBINE = 1;
const SPACE_OVERRIDE_COMBINE_REPLACE = 2;
const SPACE_OVERRIDE_REPLACE = 3;
const SPACE_OVERRIDE_REPLACE_COMBINE = 4;

var angular_damp: float setget set_angular_damp, get_angular_damp;
var audio_bus_name: String setget set_audio_bus_name, get_audio_bus_name;
var audio_bus_override: bool setget set_audio_bus_override, is_overriding_audio_bus;
var gravity: float setget set_gravity, get_gravity;
var gravity_distance_scale: float setget set_gravity_distance_scale, get_gravity_distance_scale;
var gravity_point: bool setget set_gravity_is_point, is_gravity_a_point;
var gravity_vec: Vector3 setget set_gravity_vector, get_gravity_vector;
var linear_damp: float setget set_linear_damp, get_linear_damp;
var monitorable: bool setget set_monitorable, is_monitorable;
var monitoring: bool setget set_monitoring, is_monitoring;
var priority: float setget set_priority, get_priority;
var reverb_bus_amount: float setget set_reverb_amount, get_reverb_amount;
var reverb_bus_enable: bool setget set_use_reverb_bus, is_using_reverb_bus;
var reverb_bus_name: String setget set_reverb_bus, get_reverb_bus;
var reverb_bus_uniformity: float setget set_reverb_uniformity, get_reverb_uniformity;
var space_override: int setget set_space_override_mode, get_space_override_mode;

func get_overlapping_areas() -> Area3D[]:
    pass;

func get_overlapping_bodies() -> Node3D[]:
    pass;

func overlaps_area(area: Node) -> bool:
    pass;

func overlaps_body(body: Node) -> bool:
    pass;

