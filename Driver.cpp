#include "stdafx.h"
#include<iostream>
#include<string>
#include"ProductionWorker.h"
using namespace std;
int main()
{
	ProductionWorker worker1;
	int empNum;
	try
	{
		cin >> empNum;
		worker1.setNum(empNum);
	}
	catch (Employee::InvalidEmployeeNumber)
	{
		cout << "Invalid Employee Number." << endl;
	}
	return 0;
}