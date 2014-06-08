#!/usr/bin/python

class Solution:
	# @return a float
	def findMedianSortedArrays(self, A, B):
		lenA = len(A)
		lenB = len(B)
		if lenA == 0 and lenB == 0:
			return 0.0
		if (lenA + lenB) % 2 == 1:
			return self.findKthInTwoArrays(A, B, int((lenA+lenB+1)/2))
		else:
			#print self.findKthInTwoArrays(A, B, int((lenA+lenB)/2))
			#print self.findKthInTwoArrays(A, B, int((lenA+lenB)/2+1))
			return float((self.findKthInTwoArrays(A, B, int((lenA+lenB)/2)) + self.findKthInTwoArrays(A, B, int((lenA+lenB)/2+1)))) / 2

	def findKthInTwoArrays(self, A, B, k):
		print (A, B, k)
		if (len(A)+len(B)) < k:
			raise Exception("k is too large!")
		if len(A) == 0:
			return B[k-1]
		if len(B) == 0:
			return A[k-1]
		if k == 1:
			return A[0] if A[0] < B[0] else B[0]
		offset = int(k/2)
		if len(A) < offset:
			if A[-1] < B[len(A)-1]:
				return B[k-len(A)-1]
			else:
				return self.findKthInTwoArrays(A, B[len(A):], k - len(A))
		elif len(B) < offset:
			if B[-1] < A[len(B)-1]:
				return A[k-len(B)-1]
			else:
				return self.findKthInTwoArrays(A[len(B):], B, k - len(B))
		else:
			if A[offset-1] < B[offset-1]:
				return self.findKthInTwoArrays(A[offset:], B, k - offset)
			else:
				return self.findKthInTwoArrays(A, B[offset:], k - offset)

if __name__ == '__main__':
	s = Solution()
	#A = [1, 3, 4, 5, 9, 11, 25, 56]
	A = [1, 2]
	#B = [-1, 4, 12, 24]
	B = [1, 1]
	print s.findMedianSortedArrays(A, B)
