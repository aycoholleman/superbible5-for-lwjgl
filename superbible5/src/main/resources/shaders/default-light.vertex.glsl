#version 430 core

uniform mat4 mvMatrix;
uniform mat4 pMatrix;
uniform vec4 vColor;

layout(location=0) in vec4 vFragColor;
layout(location=1) in vec4 vVertex;
layout(location=2) in vec3 vNormal;

void main(void)
{ 
	mat3 mNormalMatrix;
	mNormalMatrix[0] = mvMatrix[0].xyz;
	mNormalMatrix[1] = mvMatrix[1].xyz;
	mNormalMatrix[2] = mvMatrix[2].xyz;
	vec3 vNorm = normalize(mNormalMatrix * vNormal);
	vec3 vLightDir = vec3(0.0, 0.0, 1.0); 
	float fDot = max(0.0, dot(vNorm, vLightDir)); 
	vFragColor.rgb = vColor.rgb * fDot;
	vFragColor.a = vColor.a;
	mat4 mvpMatrix;
	mvpMatrix = pMatrix * mvMatrix;
	gl_Position = mvpMatrix * vVertex; 
}
