extends Node2D
#brief Point sampler for a [Path2D].
#desc This node takes its parent [Path2D], and returns the coordinates of a point within it, given a distance from the first vertex.
#desc It is useful for making other nodes follow a path, without coding the movement pattern. For that, the nodes must be children of this node. The descendant nodes will then move accordingly when setting the [member progress] in this node.
class_name PathFollow2D


#desc If [code]true[/code], the position between two cached points is interpolated cubically, and linearly otherwise.
#desc The points along the [Curve2D] of the [Path2D] are precomputed before use, for faster calculations. The point at the requested offset is then calculated interpolating between two adjacent cached points. This may present a problem if the curve makes sharp turns, as the cached points may not follow the curve closely enough.
#desc There are two answers to this problem: either increase the number of cached points and increase memory consumption, or make a cubic interpolation between two points at the cost of (slightly) slower calculations.
var cubic_interp: bool;

#desc The node's offset along the curve.
var h_offset: float;

#desc How far to look ahead of the curve to calculate the tangent if the node is rotating. E.g. shorter lookaheads will lead to faster rotations.
var lookahead: float;

#desc If [code]true[/code], any offset outside the path's length will wrap around, instead of stopping at the ends. Use it for cyclic paths.
var loop: bool;

#desc The distance along the path, in pixels. Changing this value sets this node's position to a point within the path.
var progress: float;

#desc The distance along the path as a number in the range 0.0 (for the first vertex) to 1.0 (for the last). This is just another way of expressing the progress within the path, as the offset supplied is multiplied internally by the path's length.
var progress_ratio: float;

#desc If [code]true[/code], this node rotates to follow the path, with the +X direction facing forward on the path.
var rotates: bool;

#desc The node's offset perpendicular to the curve.
var v_offset: float;




