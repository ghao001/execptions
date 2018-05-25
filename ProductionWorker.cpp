#include "stdafx.h"
#include"ProductionWorker.h"

void ProductionWorker::setShift(int s)
{
	if (s != 1 && s != 2)
		throw InvalidShift();
	shift = s;
}
void ProductionWorker::setPayRate(double d)
{
	if (d < 0)
		throw InvalidPayRate();
	hourlyPayRate = d;
}