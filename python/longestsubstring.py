class Solution:
	# @return an integer
	def lengthOfLongestSubstring(self, s):
		length = len(s)
		if length == 1:
			return 1

		longest = 0
		lenOfSubstr = 0

		i = 0
		start = 0
		d = {}
		while i < length:
			if s[i] in d:
				if d[s[i]] >= start:
					lenOfSubstr = i - d[s[i]]
					start = d[s[i]] + 1
				else:
					lenOfSubstr += 1
					if lenOfSubstr > longest:
						longest = lenOfSubstr
				d[s[i]] = i
			else:
				lenOfSubstr += 1
				if lenOfSubstr > longest:
					longest = lenOfSubstr
				d[s[i]] = i
			i = i+1
			#print s[start:i]
		return longest

if __name__ == '__main__':
	s = Solution()
	str = 'wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco'
	print s.lengthOfLongestSubstring(str)
				
