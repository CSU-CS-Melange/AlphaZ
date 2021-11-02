//From http://www.cs.uic.edu/~iluican/reg_detect.c

//simplified regularity detection algorithm
void main ()
{
  int i,j,cnt;
  int maxgrid=8;
  int maxrgc=8;
  int length=64;//maxgrid, maxrgc and length are the variables to be modified
  int sum_tang[maxgrid][maxgrid];
  int mean[maxgrid][maxgrid];
  int diff[maxgrid][maxgrid][length];
  int sum_diff[maxgrid][maxgrid][length];
  int tangent[maxrgc]:input;
  int path[maxgrid][maxgrid]:output;

  for( j=0; j<=maxgrid-1; j++)
  {
    sum_tang[j][j] = tangent[(maxgrid+1)*j];
    for( i=j+1; i<=maxgrid-1; i++)
    {
      sum_tang[j][i] = sum_tang[j][i-1] + tangent[i+maxgrid*j];
    }
  }

  for( j=0; j<=maxgrid-1; j++)
  {
    for( i=j; i<=maxgrid-1; i++)
    {
      for( cnt=0; cnt<=length-1; cnt++)
      {
        diff[j][i][cnt] = sum_tang[j][i];
      }
    }
  }

  for( j=0; j<=maxgrid-1; j++)
  {
    for( i=j; i<=maxgrid-1; i++)
    {
      sum_diff[j][i][0] = diff[j][i][0];
      for( cnt=1; cnt<=length-1; cnt++)
      {
        sum_diff[j][i][cnt] = sum_diff[j][i][cnt-1] + diff[j][i][cnt];
      }
      mean[j][i] = sum_diff[j][i][length-1];
    }
  }

  for( j=0; j<=maxgrid-1; j++)
  {
    for( i=j; i<=maxgrid-1; i++)
    {
      if (j>0)
      {
        path[j][i] = path[j-1][i-1]+mean[j][i];
      }
      else
      {
        path[j][i] = mean[j][i];
      }
    }
  }

}
