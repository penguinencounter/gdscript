extends RefCounted
class_name TCPServer


func get_local_port() -> int:
    pass;
func is_connection_available() -> bool:
    pass;
func is_listening() -> bool:
    pass;
func listen(port: int, bind_address: String) -> int:
    pass;
func stop() -> void:
    pass;
func take_connection() -> StreamPeerTCP:
    pass;
