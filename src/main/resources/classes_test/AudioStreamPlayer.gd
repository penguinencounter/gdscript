extends Node
class_name AudioStreamPlayer

const MIX_TARGET_STEREO = 0;
const MIX_TARGET_SURROUND = 1;
const MIX_TARGET_CENTER = 2;

var autoplay: bool setget set_autoplay, is_autoplay_enabled;
var bus: String setget set_bus, get_bus;
var mix_target: int setget set_mix_target, get_mix_target;
var pitch_scale: float setget set_pitch_scale, get_pitch_scale;
var playing: bool setget _set_playing, is_playing;
var stream: AudioStream setget set_stream, get_stream;
var stream_paused: bool setget set_stream_paused, get_stream_paused;
var volume_db: float setget set_volume_db, get_volume_db;

func get_playback_position() -> float:
    pass;

func get_stream_playback() -> AudioStreamPlayback:
    pass;

func play(from_position: float) -> void:
    pass;

func seek(to_position: float) -> void:
    pass;

func stop() -> void:
    pass;

