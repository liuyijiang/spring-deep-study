package com.util.function;

public class Tuple2<V1, V2> {
	public V1 _1;
	public V2 _2;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <V1, V2> Tuple2<V1, V2> create(V1 v1, V2 v2) {
		return new Tuple2(v1, v2);
	}
	
	private Tuple2(V1 v1, V2 v2) {
		_1 = v1;
		_2 = v2;
	}
	
	public V1 get1() {
		return _1;
	}
	
	public V2 get2() {
		return _2;
	}
	@Override
	public String toString() {
		return _1 + " " + _2;
	}
}