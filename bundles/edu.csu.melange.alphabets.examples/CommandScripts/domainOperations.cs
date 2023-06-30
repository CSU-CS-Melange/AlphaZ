domA = calc_ReadDomain("{i,j | i >= 0 && j >= 0 && i+j <= 50}");
domB = calc_ReadDomain("{i,j | 10 <= i < 60 && 15 <= j < 40}");

domIntersect = calc_Intersection(domA, domB);
print(domIntersect);

domUnion = calc_Union(domA, domB);
print(domUnion);

func1 = calc_ReadFunction("(i,j->i+j,j)");
func2 = calc_ReadFunction("(i->i-1,i+1)");

domImage = calc_Image(func1, domB);
domPreImageT = calc_PreImage(func1, domB);
print(domImage);
print(domPreImageT);

domPreImage = calc_PreImage(func2, domA);
print(domPreImage);
domPreImageT2 = calc_PreImage(func1, domA);
print(domPreImageT2);
