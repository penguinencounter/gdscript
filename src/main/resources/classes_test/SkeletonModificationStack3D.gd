extends Resource
#brief A resource that holds a stack of [SkeletonModification3D]s.
#desc This resource is used by the Skeleton and holds a stack of [SkeletonModification3D]s. The SkeletonModificationStack3D controls the order of the modifications, which controls how they are applied. Modification order is especially important for full-body IK setups, as you need to execute the modifications in the correct order to get the desired results. For example, you want to execute a modification on the spine [i]before[/i] the arms on a humanoid skeleton.
#desc Additionally, the SkeletonModificationStack3D also controls how strongly the modifications are applied to the [Skeleton3D] node.
class_name SkeletonModificationStack3D


#desc When true, the modification's in the stack will be called. This is handled automatically through the [Skeleton3D] node.
var enabled: bool;

#desc The number of modifications in the stack.
var modification_count: int;

#desc The interpolation strength of the modifications in stack. A value of [code]0[/code] will make it where the modifications are not applied, a strength of [code]0.5[/code] will be half applied, and a strength of [code]1[/code] will allow the modifications to be fully applied and override the skeleton bone poses.
var strength: float;



#desc Adds the passed-in [SkeletonModification3D] to the stack.
func add_modification(modification: SkeletonModification3D) -> void:
	pass;

#desc Deletes the [SkeletonModification3D] at the index position [param mod_idx], if it exists.
func delete_modification(mod_idx: int) -> void:
	pass;

#desc Enables all [SkeletonModification3D]s in the stack.
func enable_all_modifications(enabled: bool) -> void:
	pass;

#desc Executes all of the [SkeletonModification3D]s in the stack that use the same execution mode as the passed-in [param execution_mode], starting from index [code]0[/code] to [member modification_count].
#desc [b]Note:[/b] The order of the modifications can matter depending on the modifications. For example, modifications on a spine should operate before modifications on the arms in order to get proper results.
func execute(delta: float, execution_mode: int) -> void:
	pass;

#desc Returns a boolean that indicates whether the modification stack is setup and can execute.
func get_is_setup() -> bool:
	pass;

#desc Returns the [SkeletonModification3D] at the passed-in index, [param mod_idx].
func get_modification(mod_idx: int) -> SkeletonModification3D:
	pass;

#desc Returns the [Skeleton3D] node that the SkeletonModificationStack3D is bound to.
func get_skeleton() -> Skeleton3D:
	pass;

#desc Sets the modification at [param mod_idx] to the passed-in modification, [param modification].
func set_modification(mod_idx: int, modification: SkeletonModification3D) -> void:
	pass;

#desc Sets up the modification stack so it can execute. This function should be called by [Skeleton3D] and shouldn't be called unless you know what you are doing.
func setup() -> void:
	pass;


