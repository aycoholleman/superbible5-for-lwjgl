#version 430 core


uniform mat4 mvMatrix;
uniform mat4 pMatrix;
uniform vec3 vLightPos;
uniform vec4 vColor;

layout(location=0) in vec4 vVertex;
layout(location=1) in vec3 vNormal;
layout(location=2) in vec2 vTexCoord0;

out vec4 vFragColor;
out vec2 vTex;

void main(void)
{ 
	mat3 mNormalMatrix;
	mNormalMatrix[0] = normalize(mvMatrix[0].xyz);
	mNormalMatrix[1] = normalize(mvMatrix[1].xyz);
	mNormalMatrix[2] = normalize(mvMatrix[2].xyz);
	vec3 vNorm = normalize(mNormalMatrix * vNormal);
	vec4 ecPosition;
	vec3 ecPosition3;
	ecPosition = mvMatrix * vVertex;
	ecPosition3 = ecPosition.xyz /ecPosition.w;
	vec3 vLightDir = normalize(vLightPos - ecPosition3);
	float fDot = max(0.0, dot(vNorm, vLightDir)); 
	vFragColor.rgb = vColor.rgb * fDot;
	vFragColor.a = vColor.a;
	vTex = vTexCoord0;
	mat4 mvpMatrix;
	mvpMatrix = pMatrix * mvMatrix;
	gl_Position = mvpMatrix * vVertex; 
}
