package com.nuc.util;

import java.util.UUID;

public class UUIDMachine {
	public static String createId() {
		int machineId = 1;

		int hashCodeV = UUID.randomUUID().toString().hashCode();

		if (hashCodeV < 0) {// 有可能是负数

			hashCodeV = -hashCodeV;

		}

		// 0 代表前面补充0

		// 4 代表长度为4

		// d 代表参数为正数型

		return machineId + String.format("%015d", hashCodeV);
	}

}
