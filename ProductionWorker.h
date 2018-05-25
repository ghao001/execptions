#ifndef PRODUCTIONWORKER_H
#define PRODUCTIONWORKER_H
#include"Employee.h"
class ProductionWorker :public Employee
{
private:
	int shift;
	double hourlyPayRate;
public:
	class InvalidShift
	{};
	class InvalidPayRate
	{};
	void setShift(int);
	void setPayRate(double);
	int getShift() const
	{
		return shift;
	}
	double getPayRate() const
	{
		return hourlyPayRate;
	}
};
#endif // !PRODUCTIONWORKER_H
